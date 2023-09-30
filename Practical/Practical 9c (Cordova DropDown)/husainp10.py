import sympy as sp

# Define symbolic variables
z, n = sp.symbols('z n')


def get_sequence():
    sequence = []
    while True:
        try:
            n_terms = int(input("Enter the number of terms in the sequence: "))
            if n_terms < 0:
                print("Please enter a non-negative number of terms.")
            else:
                break
        except ValueError:
            print("Invalid input. Please enter a valid number.")

    print("Enter the sequence values:")
    for i in range(n_terms):
        while True:
            try:
                term = sp.sympify(input(f"x[{i}] = "))
                sequence.append(term)
                break
            except (sp.SympifyError, ValueError):
                print("Invalid input. Please enter a valid expression.")

    return sequence


def z_transform(sequence):
    X_z = sum(sequence[i] * z**(-i) for i in range(len(sequence)))
    return X_z


def inverse_z_transform(X_z, n_terms):
    sequence = []
    for i in range(n_terms):
        term = sp.residue(X_z * z**(i - 1), z, 0)
        sequence.append(term)
    return sequence


while True:
    print("\nMenu:")
    print("1. Calculate Z-transform")
    print("2. Calculate Inverse Z-transform")
    print("3. Exit")

    choice = input("Enter your choice: ")

    if choice == '1':
        sequence = get_sequence()
        X_z = z_transform(sequence)
        print(f"Z-transform of the sequence: {X_z}")
    elif choice == '2':
        X_z = sp.sympify(input("Enter the Z-transform expression: "))
        n_terms = int(input("Enter the number of terms in the sequence: "))
        sequence = inverse_z_transform(X_z, n_terms)
        print(f"Inverse Z-transform of the expression:")
        for i, term in enumerate(sequence):
            print(f"x[{i}] = {term}")
    elif choice == '3':
        print("Exiting the program.")
        break
    else:
        print("Invalid choice. Please select a valid option.")

    print("Husain Chaklasi")
