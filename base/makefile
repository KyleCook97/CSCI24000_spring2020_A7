Driver.class: Driver.java User.class Admin.class Customer.class
	javac -g Driver.java

User.class: User.java
	javac -g User.java

Admin.class: Admin.java User.class
	javac -g Admin.java

Customer.class: Customer.java User.class
	javac -g Customer.java

clean:
	rm *.class

run: Driver.class
	java Driver