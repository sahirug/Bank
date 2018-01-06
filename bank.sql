-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 06, 2018 at 09:26 PM
-- Server version: 10.1.10-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `accountNumber` varchar(10) NOT NULL,
  `accountType` varchar(10) NOT NULL,
  `maturityPeriod` int(11) DEFAULT NULL,
  `balance` double(10,2) NOT NULL,
  `lastAccessed` date NOT NULL,
  `dateCreated` date NOT NULL,
  `customerID` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`accountNumber`, `accountType`, `maturityPeriod`, `balance`, `lastAccessed`, `dateCreated`, `customerID`) VALUES
('ACC11894', 'savings', NULL, 58523.00, '2017-12-10', '2017-12-10', 'CUS3'),
('ACC31346', 'fixed', 24, 35000.00, '2017-12-10', '2017-12-10', 'CUS1'),
('ACC35758', 'fixed', 12, 100000.00, '2017-12-17', '2017-12-17', 'CUS4'),
('ACC36653', 'savings', NULL, 60000.00, '2017-12-10', '2017-12-10', 'CUS3'),
('ACC39667', 'fixed', 24, 100000.00, '2017-12-10', '2017-12-10', 'CUS1'),
('ACC42905', 'fixed', 6, 65000.00, '2017-12-10', '2017-12-10', 'CUS2'),
('ACC49431', 'fixed', 6, 50000.00, '2017-12-09', '2017-12-09', 'CUS1'),
('ACC90362', 'savings', NULL, 18000.00, '2017-12-09', '2017-12-09', 'CUS2');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customerID` varchar(6) NOT NULL,
  `customerName` varchar(255) NOT NULL,
  `contact` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customerID`, `customerName`, `contact`) VALUES
('CUS1', 'Sahiru', '0777352562'),
('CUS2', 'Tobias Harris', '9146548791'),
('CUS3', 'Buddy Hield', '0776598324'),
('CUS4', 'Timofey Mozgov', '0765483554');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employeeID` varchar(10) NOT NULL,
  `employeeName` varchar(255) NOT NULL,
  `designation` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employeeID`, `employeeName`, `designation`) VALUES
('EMP1', 'Mark	Reed', 'IT Manager'),
('EMP2', 'James Bennett', 'Accounts Clerk'),
('EMP3', 'Jordie Meeks', 'Security'),
('EMP4', 'Aaron Baynes', 'Accounts Clerk'),
('EMP5', 'Kemba Walker', 'Security'),
('EMP6', 'Patty Mills', 'Accounts Manager'),
('EMP7', 'Channing Frye', 'Accounts Clerk');

-- --------------------------------------------------------

--
-- Table structure for table `installment`
--

CREATE TABLE `installment` (
  `id` int(11) NOT NULL,
  `loanNumber` varchar(10) NOT NULL,
  `installmentAmount` double(10,2) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `installment`
--

INSERT INTO `installment` (`id`, `loanNumber`, `installmentAmount`, `date`) VALUES
(1, 'LN55892', 492.71, '2018-01-08'),
(2, 'LN55892', 447.92, '2018-01-03'),
(3, 'LN55892', 447.92, '2018-01-02'),
(4, 'LN55892', 492.71, '2018-01-18');

-- --------------------------------------------------------

--
-- Table structure for table `loan`
--

CREATE TABLE `loan` (
  `loanNumber` varchar(10) NOT NULL,
  `customerNumber` varchar(6) NOT NULL,
  `loanAmount` double(10,2) NOT NULL,
  `installment` double(10,2) NOT NULL,
  `paybackPeriod` int(11) NOT NULL,
  `monthlyDeadline` int(11) NOT NULL,
  `accountNumber` varchar(10) DEFAULT NULL,
  `type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loan`
--

INSERT INTO `loan` (`loanNumber`, `customerNumber`, `loanAmount`, `installment`, `paybackPeriod`, `monthlyDeadline`, `accountNumber`, `type`) VALUES
('LN55892', 'CUS1', 2500.00, 447.92, 6, 6, 'ACC39667', 'FD'),
('LN74075', 'CUS3', 12000.00, 2150.00, 6, 6, NULL, 'Normal'),
('LN80754', 'CUS2', 5000.00, 895.83, 6, 6, NULL, 'Normal'),
('LN82543', 'CUS1', 26000.00, 2491.67, 12, 6, NULL, 'Normal'),
('LN91736', 'CUS4', 32532.00, 3117.65, 12, 6, NULL, 'Normal');

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `transactionID` int(11) NOT NULL,
  `accountNumber` varchar(10) NOT NULL,
  `amount` double(10,2) NOT NULL,
  `type` varchar(15) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`transactionID`, `accountNumber`, `amount`, `type`, `date`) VALUES
(1, 'ACC36653', 255.00, 'deposit', '2018-01-01'),
(2, 'ACC90362', 7500.00, 'deposit', '2018-01-01'),
(3, 'ACC36653', 5000.00, 'deposit', '2017-12-31'),
(4, 'ACC36653', 25000.00, 'deposit', '2018-01-02'),
(5, 'ACC90362', 500.00, 'deposit', '2018-01-02'),
(6, 'ACC36653', 2400.00, 'deposit', '2018-01-02'),
(7, 'ACC36653', 254.00, 'deposit', '2018-01-02'),
(8, 'ACC36653', 3131.00, 'deposit', '2018-01-02'),
(9, 'ACC36653', 313.00, 'deposit', '2018-01-02'),
(10, 'ACC36653', 1353.00, 'withdrawal', '2018-01-02'),
(11, 'ACC36653', 10000.00, 'withdrawal', '2018-01-02'),
(12, 'ACC36653', 121.00, 'deposit', '2018-01-02'),
(13, 'ACC36653', 121.00, 'withdrawal', '2018-01-02'),
(14, 'ACC36653', 1250.00, 'withdrawal', '2018-01-02'),
(15, 'ACC36653', 8750.00, 'withdrawal', '2018-01-02'),
(16, 'ACC36653', 10000.00, 'deposit', '2018-01-02'),
(17, 'ACC36653', 500.00, 'withdrawal', '2018-01-04'),
(18, 'ACC36653', 10500.00, 'deposit', '2018-01-04'),
(19, 'ACC11894', 5000.00, 'withdrawal', '2018-01-04'),
(20, 'ACC36653', 424.00, 'withdrawal', '2018-01-05'),
(21, 'ACC36653', 424.00, 'deposit', '2018-01-05'),
(22, 'ACC11894', 53523.00, 'deposit', '2018-01-06');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(15) NOT NULL,
  `password` varchar(100) NOT NULL,
  `employeeID` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `employeeID`) VALUES
('abaynes', '1234', 'EMP4'),
('cfrye', '0000', 'EMP7'),
('jbenn', '123', 'EMP2'),
('pmills', '1234', 'EMP6'),
('root', '123456', 'EMP1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`accountNumber`),
  ADD KEY `customerID` (`customerID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customerID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employeeID`);

--
-- Indexes for table `installment`
--
ALTER TABLE `installment`
  ADD PRIMARY KEY (`id`),
  ADD KEY `loanNumber` (`loanNumber`);

--
-- Indexes for table `loan`
--
ALTER TABLE `loan`
  ADD PRIMARY KEY (`loanNumber`),
  ADD KEY `customerNumber` (`customerNumber`),
  ADD KEY `accountNumber` (`accountNumber`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`transactionID`),
  ADD KEY `accountNumber` (`accountNumber`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`),
  ADD KEY `employeeID` (`employeeID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `installment`
--
ALTER TABLE `installment`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `transactionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `account_ibfk_1` FOREIGN KEY (`customerID`) REFERENCES `customer` (`customerID`);

--
-- Constraints for table `installment`
--
ALTER TABLE `installment`
  ADD CONSTRAINT `installment_ibfk_1` FOREIGN KEY (`loanNumber`) REFERENCES `loan` (`loanNumber`);

--
-- Constraints for table `loan`
--
ALTER TABLE `loan`
  ADD CONSTRAINT `loan_ibfk_1` FOREIGN KEY (`customerNumber`) REFERENCES `customer` (`customerID`),
  ADD CONSTRAINT `loan_ibfk_2` FOREIGN KEY (`accountNumber`) REFERENCES `account` (`accountNumber`);

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`accountNumber`) REFERENCES `account` (`accountNumber`);

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`employeeID`) REFERENCES `employee` (`employeeID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
