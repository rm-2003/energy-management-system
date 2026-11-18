USE EMS;

DELIMITER //

CREATE PROCEDURE delete_complaint(IN supplier_ID INT, IN complaint_ID INT, OUT result INT)
BEGIN
    DECLARE complaint_exists INT;
    -- Check if the complaint ID exists
    SELECT COUNT(*) INTO complaint_exists FROM complain WHERE Complain_Id = complaint_ID;
    -- If both supplier ID and complaint ID exist, delete the complaint
    IF complaint_exists = 1 THEN
        DELETE FROM complain WHERE Complain_Id = complaint_ID;
        SET result = 1; -- Return 1 if successful
    ELSE
        SET result = 0; -- Return 0 if either supplier ID or complaint ID doesn't exist
    END IF;
END//

DELIMITER ;



DELIMITER //

CREATE PROCEDURE exchange_credits(IN partner_ID INT, IN credits_to_exchange INT, IN consumer_ID INT, OUT result INT)
BEGIN
    DECLARE partner_credits INT;
    DECLARE customer_credits INT;
    DECLARE permits INT;
    
    -- Check if the partner has sufficient credits
    SELECT Balance_Industry INTO partner_credits FROM industrial_consumer WHERE Industrial_Consumer_Id = partner_ID;
    SELECT Balance_Industry INTO customer_credits FROM industrial_consumer WHERE Industrial_Consumer_Id = consumer_ID;
    SELECT NON_REC_permits INTO permits FROM industrial_consumer WHERE Industrial_Consumer_Id = consumer_ID;

    -- If partner has enough credits
    IF partner_credits >= credits_to_exchange AND customer_credits+credits_to_exchange < permits THEN
        -- Decrease credits from the partner and increase credits for the industrial consumer in a single UPDATE statement
        UPDATE industrial_consumer
        SET Balance_Industry = CASE
                                WHEN Industrial_Consumer_Id = partner_ID THEN Balance_Industry - credits_to_exchange
                                WHEN Industrial_Consumer_Id = consumer_ID THEN Balance_Industry + credits_to_exchange
                              END
        WHERE Industrial_Consumer_Id IN (partner_ID, consumer_ID);
        
        -- Set result to 1 to indicate successful exchange
        SET result = 1;
    ELSE
        -- Set result to 0 to indicate insufficient credits
        SET result = 0;
    END IF;
END//

DELIMITER ;
