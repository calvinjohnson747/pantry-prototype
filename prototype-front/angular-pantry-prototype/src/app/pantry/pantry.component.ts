import { Component, OnInit} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';

export interface Items{
    itemId: number;
    itemName: string;
}

@Component({
  selector: 'app-pantry',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './pantry.component.html',
  styleUrl: './pantry.component.css'
})
export class PantryComponent implements OnInit {
    items: Items[] = [];
    addForm!: FormGroup;

    constructor(private httpClient: HttpClient, private router: Router, private formBuilder: FormBuilder){
      this.addForm = this.formBuilder.group({
        itemName:['']
      });
    }

    ngOnInit(): void{
      this.fetchItems();
    }

    fetchItems(): void {
      this.httpClient.get<Items[]>('http://localhost:8080/getitems')
      .subscribe({
        next: (item) => (this.items = item),
        error: (error) => console.error('Error fetching items: ',error)
      });
    }

    deleteItem(itemId: number): void{
      if(confirm('Are you sure you want to delete this item?')){
        this.httpClient
        .delete(`http://localhost:8080/delete/${itemId}`)
        .subscribe({
          next: ()=>{
            this.items = this.items.filter(item => item.itemId!== itemId);
            console.log('Item deleted successfully');
          },
          error: (error) => console.error('Error deleting items:', error)
        });
      }
    }

    addItem(): void {
        const newItem = this.addForm.value;
        console.log(newItem);
        this.httpClient.post<Items>('http://localhost:8080/post', newItem)
          .subscribe({
            next: (addedItem) => {
              this.items.push(addedItem);
              console.log('Item added successfully:', addedItem);
            },
            error: (error) => console.error('Error adding item:', error)
          });
    }

}
