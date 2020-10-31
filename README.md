# Java Pattern Matching
The goal of this project is to try out a simple way of implementing Elm and Haskell style
pattern matching in Java.

Take this elm code for example
```elm
type UsernameValidationResult
    = ShorterThanMinLength
    | LongerThanMaxLength
    | CorrectUsername
```
We have a type `UsernameValidationResult` that can take any of the following four values.
In Elm we could then have our validation method return one of those values and based on that
chose our next action using a `case` statement like this
```elm
persistUsername : Username -> Username
persistUsername username =
    let
        validationResult = validateUsername username
    in
    case validationResult of
        ShorterThanMinLength ->
            -- TODO: Throw error

        LongerThanMaxLength ->
            -- TODO: Throw error

        CorrectUsername ->
            -- TODO: On success simply return the username
```
Now I should mention that this code, while syntactically correct, doesn't make much sense in
elm. From what I know (still an Elm beginner) we usually don't persist stuff in a database
and we most certainly don't throw exceptions. (In fact one of Elms guarantees is no runtime errors)
<br>
The point however that this is, in my humble opinion, a really simple way of handling cases where you have to choose between a multitude of options/results, like when performing validation, remains valid.

When encountering a similar example at work, with Java as our main backend language, I sought a way to make the validation as simple and clean as possible. This project exists to try out what I came up with and, if it works, keep it for future reference.
