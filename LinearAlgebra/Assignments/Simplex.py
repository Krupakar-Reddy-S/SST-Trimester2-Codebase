def simplex(A, b, c):
    num_x = len(c)
    num_s = len(b)
    num_vars = num_x + num_s

    # Initialize tableau
    tableau = [row + [0] * i + [1] + [0] * (num_s - i - 1) + [b[i]] for i, row in enumerate(A)]
    tableau.append([c[i] if i < num_x else 0 for i in range(num_vars)] + [0])

    while any(val > 0 for val in tableau[-1][:-1]):
        # Bland's rule: Choose the leftmost column with a positive coefficient in the last row
        pivot_col = next(i for i, val in enumerate(tableau[-1][:-1]) if val > 0)

        # If no row can be pivot row, then the problem is unbounded
        if all(row[pivot_col] <= 0 for row in tableau[:-1]):
            raise ValueError('Problem is unbounded')

        # Bland's rule: Choose the row with the smallest non-negative ratio for the pivot row
        ratios = [(i, row[-1] / row[pivot_col]) for i, row in enumerate(tableau[:-1]) if row[pivot_col] > 0]
        pivot_row, _ = min(ratios, key=lambda x: (x[1], x[0]))

        pivot_val = tableau[pivot_row][pivot_col]

        # Pivot
        tableau[pivot_row] = [val / pivot_val for val in tableau[pivot_row]]
        for i, row in enumerate(tableau):
            if i != pivot_row:
                tableau[i] = [row[j] - tableau[pivot_row][j] * row[pivot_col] for j in range(num_vars + 1)]

# Extract solution
    x = [0] * num_x
    for i, row in enumerate(tableau[:-1]):
        for j, val in enumerate(row[:-1]):
            if val == 1 and j < num_x:  # Ensure j is within the range of x
                x[j] = tableau[i][-1]
                
    return x


def test_simplex():
    # Test case 1
    A = [[1, 1], [2, 1]]
    b = [2, 3]
    c = [3, 2]
    x = simplex(A, b, c)
    print(x)  # Expected output: [1.0, 1.0]

    # Test case 2
    A = [[1, 2], [2, 1]]
    b = [6, 8]
    c = [5, 8]
    x = simplex(A, b, c)
    print(x)  # Expected output: [2.0, 2.0]

    # Test case 3
    A = [[1, 1, 1], [2, 2, 1]]
    b = [7, 12]
    c = [10, 20, 30]
    x = simplex(A, b, c)
    print(x)  # Expected output: [0.0, 0.0, 7.0]

    # Test case 4: Unbounded problem
    A = [[-1, 1], [1, -2]]
    b = [1, 2]
    c = [1, 1]
    try:
        x = simplex(A, b, c)
    except ValueError as e:
        print(e)  # Expected output: 'Problem is unbounded'

# test_simplex()

A = [
    [3, 5, 6],
    [1, 1, 1],
    [1, 1, 2]
]

b = [1000, 200, 280]
c = [50, 100, 150]

X = simplex(A, b, c)
value = sum([a * b for a, b in zip(X, c)])

print(X) # Expected output: [0, 80.0, 100.0]
print(value)  # Expected output: 23000