answer = input('Digit something:')
print('The primitive type of this value is ', type(answer))
if answer .isalpha():
    print('You choose a letter.')
else:
    print("There isn't only letters")

if answer .isnumeric():
    print('You choose a number.')
else:
    print("There isn't only numbers.")

if answer .isalnum():
    print('At least, you choose one number and/or one letter, or both.')
else:
    print("There isn't numbers or letters.")

if answer .isupper():
    print('All the letters are in capslock.')
else:
    print("At least, one letter isn't capslock")

if answer. islower():
    print('All the letter are in lowercase')
else:
    print("At least, one letter isn't lowercase")

if answer .isdigit():
    print('You choose something that is a digit.')
else:
    print("You didn't choose a digit.")
