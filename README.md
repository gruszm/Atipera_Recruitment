<h1>This is a repository with the recruitment task for Atipera.</h1>

Given username, the api consumer can return all repositories of a user, which are not forks.
For each repossitory there is also owner's login and all branches.
Each branch has its name and last commit's sha.

When given a not existing user, the api will return a response with format:
```
{
    "status": ${responseCode}
    "message: ${whyHasItHappened}
}
```

The base URL is `ip:port/api`, for example `localhost:8080/api`.

The specific URL required for this task is `ip:port/api/repos/username`, for example `localhost:8080/api/repos/gruszm`:

![Zrzut ekranu 2024-08-05 124510](https://github.com/user-attachments/assets/26e794d8-adc5-4694-9aff-d5a37a2bf32e)

API's response when given a not existing user:

![Zrzut ekranu 2024-08-05 113041](https://github.com/user-attachments/assets/ee76d9b6-ce37-452d-8d1c-c268756fefc5)

Should any other error occur, API will also return a corresponding response:

![Zrzut ekranu 2024-08-05 113213](https://github.com/user-attachments/assets/94265a30-ce82-43a6-919a-08b20c45de2a)

![Zrzut ekranu 2024-08-05 115123](https://github.com/user-attachments/assets/245de1d2-c691-41fb-9897-09e2a37d07cc)

<h4>In the service, ResponseEntity objects were used. On second thought I would probably create individual Exceptions and throw them on error occurrence.
  The exceptions would be then handled in the controller.</h4>
