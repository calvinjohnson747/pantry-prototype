FROM node:alpine

# Set working directory
WORKDIR /usr/src/app

# Copy package.json and package-lock.json to leverage Docker cache
COPY package.json package-lock.json ./

# Install dependencies
RUN npm install

# Install Angular CLI globally
RUN npm install -g @angular/cli@latest

# Copy the rest of the application code
COPY . .

# Expose the port
EXPOSE 4200

# Start the Angular CLI development server
CMD ["ng", "serve", "--host", "0.0.0.0", "--configuration=development"]
