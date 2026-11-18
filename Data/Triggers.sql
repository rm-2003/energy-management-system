DELIMITER //

CREATE TRIGGER UpdateBalanceOnConsumption 
AFTER INSERT ON Consumption
FOR EACH ROW
BEGIN
    IF NEW.Consumer_type = "HOUSEHOLDS" THEN
        UPDATE Household_Consumer
        SET Balance = Balance - NEW.units_consumed
        WHERE Household_Consumer_Id = NEW.Consumer_Id;
    ELSE
        UPDATE Industrial_Consumer
        SET Balance_Industry = Balance_Industry - NEW.units_consumed
        WHERE Industrial_Consumer_Id = NEW.Consumer_Id;
    END IF;
END;

CREATE TRIGGER UpdateBalanceOnTransaction
AFTER INSERT ON Transaction
FOR EACH ROW
BEGIN
    IF NEW.Consumer_type = "HOUSEHOLDS" THEN
        UPDATE Household_Consumer
        SET Balance = Balance + NEW.No_Of_Credits
        WHERE Household_Consumer_Id = NEW.Consumer_Id;
    ELSIF NEW.consumer_type = "INDUSTRIAL" THEN
        UPDATE Industrial_Consumer
        SET Balance_Industry = Balance_Industry + NEW.No_Of_Credits
        WHERE Industrial_Consumer_Id = NEW.Consumer_Id;
    END IF;
END;

DELIMITER ;