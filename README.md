# How should I start
1. check if TaskApplication is starting.
2. run tests by using mvn wrapper to check if everything works fine.

## Scenario

Let's imagine that during the team discussion you agreed on the final solution for the infection tracker:
- Apps will internally store a list of userIds the user encountered, together with a timestamp
- the server will store a list of all infected people
- Apps can ask the server to return ids of all infected people and then do the matching on the client side.
- Apps can inform the server about a new infection.

## Task 1
Add new endpoint to fetch the list of infected people only from the past 2 weeks. The period from which to fetch the list should be provided by the Apps.

## Task 2
Implement caching in the backend for the existing endpoint. Please don't use any libraries to achieve it, just plain Java.