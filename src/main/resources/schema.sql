CREATE DATABASE IF NOT EXISTS banking_api;
USE banking_api;

-- Users Table
CREATE TABLE `users` (
                         `id` bigint(20) NOT NULL AUTO_INCREMENT,
                         `name` varchar(100) NOT NULL,
                         `email` varchar(100) NOT NULL,
                         `password` varchar(255) NOT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Accounts Table
CREATE TABLE `accounts` (
                            `id` bigint(20) NOT NULL AUTO_INCREMENT,
                            `account_number` varchar(20) NOT NULL,
                            `balance` DECIMAL(15, 2) NOT NULL DEFAULT 0.00,
                            `user_id` bigint(20) NOT NULL,
                            PRIMARY KEY (`id`),
                            UNIQUE KEY `account_number` (`account_number`),
                            KEY `user_id` (`user_id`),
                            CONSTRAINT `fk_user_account` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Transactions Table
CREATE TABLE `transactions` (
                                `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                `account_id` bigint(20) NOT NULL,
                                `type` varchar(20) NOT NULL, -- 'DEPOSIT', 'WITHDRAW', 'TRANSFER'
                                `amount` DECIMAL(15, 2) NOT NULL,
                                `balance_after` DECIMAL(15, 2) NOT NULL,
                                `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
                                PRIMARY KEY (`id`),
                                KEY `account_id` (`account_id`),
                                CONSTRAINT `fk_account_transaction` FOREIGN KEY (`account_id`) REFERENCES `accounts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;