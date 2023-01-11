INSERT INTO COMPANIES(cuit, business_name, joining_date) VALUES ('343524', 'disney', '2022-12-22');
INSERT INTO COMPANIES(cuit, business_name, joining_date) VALUES ('111111', 'balut', '2022-11-11');
INSERT INTO COMPANIES(cuit, business_name, joining_date) VALUES ('222222', 'pepsi', '2022-10-22');

INSERT INTO TRANSFERS(id, cost, debit_account, credit_account, transfer_date, company_id) VALUES (1, '3.44', '1234', '5678', '2022-12-11', 1);
INSERT INTO TRANSFERS(id, cost, debit_account, credit_account, transfer_date, company_id) VALUES (2, '3.44', '1234', '5678', '2022-12-09', 1);
INSERT INTO TRANSFERS(id, cost, debit_account, credit_account, transfer_date, company_id) VALUES (3, '6.23', '5832', '2377', '2021-11-23', 2);
INSERT INTO TRANSFERS(id, cost, debit_account, credit_account, transfer_date, company_id) VALUES (4, '8.99', '9907', '6969', '2020-10-30', 3);