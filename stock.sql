-- Dumping database structure for stock-management
CREATE DATABASE IF NOT EXISTS `stock-management`;
USE `stock-management`;
DROP TABLE IF EXISTS `stocks`;

-- Dumping structure for table stock-management.stocks
CREATE TABLE IF NOT EXISTS `stocks` (
    `stock_id` int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `quarter` int(2) NOT NULL,
    `name` varchar(200) NOT NULL,
    `log_date` Date NOT NULL,
    `open_value` double(15, 2) NOT NULL,
    `high_value` double(15, 2) NOT NULL,
    `low_value` double(15, 2) NOT NULL,
    `close_value` double(15, 2) NOT NULL,
    `volume` int(15) NOT NULL,
    `percent_change_price` decimal(10, 6) signed,
    `percent_change_volume_over_last_wk` decimal(10, 6) signed,
    `previous_weeks_volume` int(15),
    `next_weeks_open_value` double(15, 2),
    `next_weeks_close_value` double(15, 2),
    `percent_change_next_weeks_price` decimal(10, 6) signed,
    `days_to_next_dividend` int(5),
    `percent_return_next_dividend` decimal(10, 6) signed,
	UNIQUE KEY `ID_PK` (`stock_id`),
	UNIQUE KEY `QNAME_UX` (`log_date`, `name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;