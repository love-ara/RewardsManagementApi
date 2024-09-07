truncate table customer_rewards cascade;
truncate table cashback_transaction cascade;


INSERT INTO customer_rewards(customer_id, total_cashback, current_balance)
VALUES (100, 200.00, 50.00), (200, 200.00, 150.00), (300, 300.00, 250.00);


INSERT INTO cashback_transaction(transaction_id, amount_earned, description, customer_id)
VALUES (1, 25.00, 'Booking #1234', 100), (2, 15.00, 'Booking #2345', 200), (3, 30.00, 'Booking #3456', 100);