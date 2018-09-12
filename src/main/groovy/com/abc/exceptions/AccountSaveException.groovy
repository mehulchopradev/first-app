package com.abc.exceptions

class AccountSaveException extends Exception {
  def failedAccount

  String message

  AccountSaveException(account, message) {
    super(message)
    this.failedAccount = account
  }
}
