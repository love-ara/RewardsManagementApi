truncate table customer_rewards cascade;
truncate table cashback_transaction cascade;


INSERT INTO customer_rewards(customer_id, total_cashback, current_balance)
VALUES (1, 200.00, 50.00),(2, 200.00, 150.00),(1, 300.00, 250.00);

INSERT INTO cashback_transaction(amount_earned, description, customer_id)
VALUES (25.00, 'Booking #1234', 1),
       (15.00, 'Booking #2345', 2),
       (30.00, 'Booking #3456', 1);