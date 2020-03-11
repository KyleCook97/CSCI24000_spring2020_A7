Driver.class: Driver.java User.class Admin.class Customer.class Account.class Savings.class Checking.class
	javac -g Driver.java

User.class: User.java
	javac -g User.java

Admin.class: Admin.java User.class
	javac -g Admin.java

Customer.class: Customer.java User.class
	javac -g Customer.java

Account.class: Account.java
	javac -g Account.java

Savings.class: Savings.java Account.class
	javac -g Savings.java

Checking.class: Checking.java Account.class
	javac -g Checking.java
	
clean:
	rm *.class

run: Driver.class
	java Driver