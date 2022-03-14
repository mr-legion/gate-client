package io.gate.domain.account;

/**
 * Transaction status.
 */
public enum TransactionStatus {
    PEND,
    DONE,
    MANUAL,
    CANCEL,
    EXTPEND,
    FAIL,
    REQUEST,
    BCODE
}