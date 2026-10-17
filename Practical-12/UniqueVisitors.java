@Override
public String toString() {
    return "Account Number: " + accountNumber + ", Owner Name: " + ownerName + ", Balance: " + balance + ", Active: " + active;
}
   @Override
public boolean equals(Object o) {

    if (!(o instanceof Account)) {
        return false;
    }
    Account other = (Account) o;
    return this.accountNumber.equals(other.accountNumber);
}
@Override
public int hashCode() {
    return accountNumber.hashCode();
}
