truncate table customers cascade;
truncate table customer_rewards cascade;
truncate table cashback_transaction cascade;



INSERT INTO customers(customer_id, email, password, time_created)
values(200, 'john@email.com', '$2a$10$pIkGwDeIlvmq0BdfnMLh5u.hme/NmaWiqrbW6UJwuQnjHCOuMbl6a',
       '2024-09-07T15:40:13.394812100'),
      (201, 'jane@email.com', '$2a$10$pIkGwDeIlvmq0BdfnMLh5u.hme/NmaWiqrbW6UJwuQnjHCOuMbl6a',
      '2024-09-07T15:40:13.394812100');

INSERT INTO customer_rewards(customer_id, total_cashback, current_balance)
VALUES (100, 200.00, 50.00), (200, 200.00, 150.00), (300, 300.00, 250.00);


INSERT INTO cashback_transaction(transaction_id, amount_earned, description, customer_id)
VALUES (1, 25.00, 'Booking #1234', 100), (2, 15.00, 'Booking #2345', 200), (3, 30.00, 'Booking #3456', 100);