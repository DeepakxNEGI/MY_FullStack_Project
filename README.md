# MY_FullStack_Project
# Food Delivery Project

## Overview
This food delivery system allows users to browse a variety of food menus, filter by categories, search by food names, view detailed food information, and place orders with easy payment integration using Razorpay. It also includes an admin panel to manage food items, orders, and users.

## Features

- **Browse Food Menu**: View a wide range of food items available for delivery.
- **Filter by Category**: Filter food items based on categories (e.g., starters, main course, desserts, etc.).
- **Filter by Food Name**: Search and filter food items by name for quick access.
- **View Food Details**: Get detailed information about each food item, including ingredients, price, and nutritional details.
- **Add to Cart**: Add selected food items to the shopping cart for easy ordering.
- **Remove from Cart**: Remove unwanted items from the cart with a single click.
- **Login and Register**: User authentication to access personalized features like order history and profile.
- **Place Order**: Users can place an order with their selected items, and choose delivery options.
- **Razorpay Payment**: Secure online payment integration using Razorpay for easy transactions.
- **View Orders**: Users can view their past and current orders, including status and delivery tracking.
- **Admin Panel**: Admin users can manage food items, view and manage orders, and update the status of ongoing orders.

## Technologies Used

- **Frontend**: React, HTML, CSS, JavaScript
- **Backend**: Spring Boot, RESTful API
- **Database**: MySQL/PostgreSQL
- **Payment Gateway**: Razorpay API
- **Authentication**: JWT (JSON Web Tokens) for secure login and user sessions

## Installation

1. Clone the repository to your local machine:
    ```bash
    git clone <repository-url>
    ```

2. Navigate to the project directory:
    ```bash
    cd food-delivery-project
    ```

3. Install the dependencies:
    - For Frontend:
      ```bash
      cd frontend
      npm install
      ```

    - For Backend:
      ```bash
      cd backend
      mvn install
      ```

4. Configure your database and environment settings in the `application.properties` file in the backend folder.

5. Run the application:
    - For Frontend:
      ```bash
      npm start
      ```

    - For Backend:
      ```bash
      mvn spring-boot:run
      ```

## Usage

- Create a new account or log in using your existing credentials.
- Browse the menu, filter items, and add items to your cart.
- Proceed to checkout and complete the payment via Razorpay.
- Track your orders and view the order history.

## Admin Panel

The admin panel is accessible through the `/admin` route. Admin users can log in using the admin credentials and can manage food items, view all orders, and update order statuses.

## Contributing

If you would like to contribute to this project, feel free to fork the repository and submit a pull request. All contributions are welcome!



