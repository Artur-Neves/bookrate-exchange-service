CREATE TABLE exchange (
id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
from_currency VARCHAR(5) NOT NULL,
to_currency VARCHAR(5) NOT NULL,
conversion_factor DOUBLE NOT NULL,
UNIQUE(from_currency, to_currency)
);