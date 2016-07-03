# reporter

This app summarises survey results (in csv format) and produces a nice console output.

### Using it

Clone the repo using `git clone`.

Then run `./gradlew installDist` to create the binary.

Then run `./build/install/reporter/bin/reporter ./example-data/survey-1.csv ./example-data/survey-1-responses.csv`.

Your output should look something like:

```
----------------------------------------------
Survey Summary
----------------------------------------------
Participant count: 5
Participation percentage: 83.3
----------------------------------------------

Q: I like the kind of work I do.
Average rating: 4.6

Q: In general, I have the resources (e.g., business tools, information, facilities, IT or functional support) I need to be effective.
Average rating: 5.0

Q: We are working at the right pace to meet our goals.
Average rating: 5.0

Q: I feel empowered to get the work done for which I am responsible.
Average rating: 3.6

Q: I am appropriately involved in decisions that affect my work.
Average rating: 3.6
----------------------------------------------
```
