# Client and Project Management Application

Currently a work in progress.

## M.V.P. (Minimum Viable Product):

- [ ] Add / update clients; should be able to add / update one or more projects under each client.

- [ ] Register new client functionality; should accept signed agreement as a mandatory attachment (should accept only PDF).

- [ ] View client and its projects.

- [ ] Cancel projects.

## Stretch:

- [ ] Notification: Asynchronous email notifications on successful project creation and cancelation.

## Major Technologies:

- Spring Boot

- Hibernate

- JPA

- MySQL

- React

## Deliverables:

### REST API w/ CRUD operations:

API:

- Proper use of HTTP methods, Parameters, Headers & response codes
  JSON should be used for request and response with proper input validation.

- Basic Authentication

- Proper exception handling

- Average / Maximum number of requests to be processed: 10/50 request per sec.
  98 % real-time operation should be completed within min 1 sec to max 5 sec

Database:

- RDBMS design and DDL script

- ORM implementation with transaction management

### Single Page Application / User Interface:

- Responsive UI integrated with APIs.

- Common UI best practices (forms, CSS, validation, proper content including success / failure messages, spacing, etc.)

### Unit testing:

Unit testing (Automation via Junit; Test case depth, see: coverage, addressing positive and negative scenarios, etc.)

### Asynchronous processing (optional):

- Fire and forget implementation using naked thread implementation or messaging queues.

- Date loss prevention in case of exceptional scenario (see: reliable messaging).

Note: Have a static login page with hardcoded role(s) (should be based on json configuration).
