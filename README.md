# SRS README

## Table of Contents
1. [Introduction](#introduction)
2. [Functional Requirements](#functional-requirements)
   - [User Authentication](#user-authentication)
   - [Account Balance Inquiry](#account-balance-inquiry)
   - [Cash Withdrawal](#cash-withdrawal)
   - [Cash Deposit](#cash-deposit)
   - [PIN Change](#pin-change)
   - [Transfer to Joint Account](#transfer-to-joint-account)
   - [User Menu Display](#user-menu-display)
3. [Non-Functional Requirements](#non-functional-requirements)
   - [Usability](#usability)
   - [Reliability](#reliability)
4. [Conclusion](#conclusion)

## Introduction
This document outlines the Software Requirements Specification (SRS) for our banking system. It describes the system's functional and non-functional requirements, providing a detailed overview for developers, testers, and stakeholders.

## Functional Requirements

### User Authentication
- **Authentication Method**: The system must authenticate users using their User ID and PIN.
- **Failed Login Handling**: The system should block the user for 60 seconds after three failed login attempts.

### Account Balance Inquiry
- **Balance View**: The system should allow users to view their account balance.

### Cash Withdrawal
- **Withdrawal Denominations**: The system should allow users to withdraw cash in predefined denominations (e.g., $20, $50, $100, $200).
- **Fund Availability Check**: The system should check if sufficient funds are available before processing a withdrawal.

### Cash Deposit
- **Deposit Method**: The system should allow users to deposit cash by processing input from a file (for simplicity).

### PIN Change
- **PIN Verification**: The system should allow users to change their PIN after verifying their current PIN.

### Transfer to Joint Account
- **Fund Transfer**: The system should allow primary account users to transfer funds to a linked joint account.

### User Menu Display
- **Menu Appropriateness**: The system should display appropriate menus for primary and joint account users.

## Non-Functional Requirements

### Usability
- **GUI Design**: The system should have an intuitive, user-friendly graphical user interface (GUI).
- **User Guidance**: The system should provide clear messages and instructions to users.

### Reliability
- **System Availability**: The system should be available 99.9% of the time.

## Conclusion
This document provides a comprehensive overview of the functional and non-functional requirements for the banking system. Adherence to these requirements will ensure the system meets user needs and maintains high standards of usability and reliability.
