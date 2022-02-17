Hi 👋
At SpeedLedger, we take great care about who we’re hiring. Finding out that a person is right for us and vice versa takes some time and effort. Therefore, the next step in our hiring process is for you to implement some tasks. The assignment serves two purposes:

We get more information about you as a candidate.
It will serve as a base for a potential second test where you will solve tasks with a little more complexity.
The assignment can be found below. Put your solution as a PR to this repository and we'll take a look as soon as it's up.

Have fun coding!

AccountService - a simple REST service
The goal of this test is to create a simple REST-based web service which can provide information about bank accounts.

See below for a a step-by-step description of the functionality needed.

You are free to implement this service in any way you like. Choose the language, framework or library that you like or feel comfortable with. Show us how you think code should be written.

Finally, some things on how we think about writing code.

Aim for "clear and concise". Make it easy for someone else to understand how it works, and do not overcomplicate things. This is not an "as few lines of code as possible" competition but we also don't want an overblown "enterprise" solution.
It is not necessary to write everything yourself. If you can use some kind of existing REST service framework rather than implementing low-level code which deals with sockets, it is probably a good idea.
1. Create a /bankaccounts endpoint
The first part is creating a single endpoint named /bankaccounts which returns a list of bank accounts, according to the specification below.

The endpoint should accept a GET requests and return a JSON array consisting of zero or more objects with the following schema:

Name	Value type	Description
id	number	Unique identifier for this account.
number	string	The number used by the bank to identify this account.
name	string	Human-readable name of the bank account.
balance	number	The amount of money (positive or negative) on the bank account.
creditcard	boolean	Whether this bank account represents a credit card.
synthetic	boolean	True if a bank account is "synthetic", i.e. representing some "bank account like" thing, but not an actual bank account.
In a realistic scenario, the data would be retrieved from somewhere else, but for this test the /bankaccounts endpoint will always return hard-coded data.

Below is an example response with some data you can use for experimenting.

[
    {"id": 1, "number": "1357756", "name":"Personal account", "creditcard": false, "synthetic": false, "balance": 1202.14},
    {"id": 2, "number": "2446987", "name":"Business account", "creditcard": false, "synthetic": false, "balance": 34057.00}
    {"id": 3, "number": "9981644", "name":"Credit card", "creditcard": true, "synthetic": false, "balance": -10057.00}
    {"id": 4, "number": "", "name":"Expense claims", "creditcard": false, "synthetic": true, "balance": 0}
]
After implementing this endpoint and started your web service, you should be able to enter the host name of your web service followed by /bankaccounts in your browser and see the data returned.

2. Add a /bankaccounts/default endpoint
With the /bankaccounts endpoint in place, lets add another one. This one is named /bankaccounts/default and returns a single value. It also expects a GET request and returns JSON-data.

The "default" account is the bank account we think is the one most likely to be interesting to the user. Here follows a description of the logic which determines the value to return.

If there is a bank account with a positive balance that is at least twice as high as all other bank accounts, return the id of that account.
If there is only a single bank account, return the id of that account.
Synthetic bank accounts can never be chosen as default account.
Accounts with negative balance can never be chosen as default accounts.
If no account satisfied the above, return null.
This method should operate on the same data returned by the /bankaccounts endpoint.

3. Write unit tests
Now we have added two endpoints. Especially the second one (/bankaccounts/default) has some logic. The third step is therefore to add unit tests. (If you haven't done so already!)

Add unit tests until you feel confident that you have tested all combinations which can occur.

4. Submission
When you are happy with the code you have written, create a PR! :shipit:
