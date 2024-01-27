import numpy as np

def simplex(A, b, c):
    m, n = A.shape
    tableau = np.zeros((m + 1, n + m + 1))
    tableau[:m, :n] = A
    tableau[:m, -1] = b
    tableau[-1, :n] = -c
    tableau[:-1, -2] = 1
    basic_vars = list(range(n, n + m))

    print(tableau, end="\n\n")

    while True:
        entering_col = np.argmax(tableau[-1, :-1])
        if tableau[-1, entering_col] <= 0:
            break

        ratios = tableau[:-1, -1] / tableau[:-1, entering_col]
        ratios[ratios < 0] = np.inf
        leaving_row = np.argmin(ratios)

        pivot = tableau[leaving_row, entering_col]
        tableau[leaving_row, :] /= pivot

        for i in range(m + 1):
            if i != leaving_row:
                factor = tableau[i, entering_col]
                tableau[i, :] -= factor * tableau[leaving_row, :]

        basic_vars[leaving_row] = entering_col
    
    print(tableau, end="\n\n")

    solution = np.zeros(n + m)
    solution[basic_vars] = tableau[:-1, -1]

    return solution

A = np.array([[1, -1], [3, 1], [4, 3]])
b = np.array([2, 5, 7])
c = np.array([1, 1])

result = simplex(A, b, c)
print("Optimal solution:", result)
