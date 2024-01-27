def solve(A, b):
    """A is a m x n matrix, and b is an n x 1 vector.
    returns: x, where x is the solution to the equation Ax = b
    if no solution exists, return -1
    if infinite solutions exist, return -2"""

    m, n = len(A), len(A[0])
    
    # Check for incompatible dimensions
    if m != len(b):
        raise ValueError("Incompatible dimensions: A is {}x{}, but b is {}x1".format(m, n, len(b)))

    augmented_matrix = [row + [bi] for row, bi in zip(A, b)]

    # Perform Gaussian elimination
    for i in range(min(m, n)):
        pivot_row = max(range(i, m), key=lambda k: abs(augmented_matrix[k][i]))
        augmented_matrix[i], augmented_matrix[pivot_row] = augmented_matrix[pivot_row], augmented_matrix[i]

        if augmented_matrix[i][i] == 0:
            return -1  # No unique solution

        for j in range(i + 1, m):
            factor = augmented_matrix[j][i] / augmented_matrix[i][i]
            for k in range(i, n + 1):
                augmented_matrix[j][k] -= factor * augmented_matrix[i][k]

    # Back substitution
    x = [0] * n
    for i in range(m - 1, -1, -1):
        if augmented_matrix[i][i] == 0:
            return -1  # No unique solution
        x[i] = augmented_matrix[i][-1] / augmented_matrix[i][i]
        for j in range(i - 1, -1, -1):
            augmented_matrix[j][-1] -= augmented_matrix[j][i] * x[i]

    # Check for infinite solutions
    for i in range(m, n):
        if augmented_matrix[i][-1] != 0:
            return -2  # Infinite solutions

    return x


def det(A):
    """calculates the determinant of A
    if A is not a square matrix, return 0"""

    n = len(A)
    if n == 2:
        return A[0][0]*A[1][1] - A[0][1]*A[1][0]

    determinant = 0
    for c in range(n):
        determinant += ((-1) ** c) * A[0][c] * det([row[:c] + row[c+1:] for row in (A[:0]+A[0+1:])])
    return determinant


def gauss_jordan_elimination(matrix):
    n = len(matrix)
    for i in range(n):
        pivot = matrix[i][i]
        for j in range(n + 1):
            matrix[i][j] /= pivot
        for k in range(n):
            if k != i:
                factor = matrix[k][i]
                for j in range(n + 1):
                    matrix[k][j] -= factor * matrix[i][j]

    solution = [row[n] for row in matrix]
    return solution


# Example usage of the solve function
A = [[2, 3], [5, 2]]
b = [8, 9]
solution = solve(A, b)
print(solution)  # Expected output: [1, 2]

A = [[1, 2, 3], [4, 5, 6], [7, 8, 10]]
b = [6, 15, 25]
solution = solve(A, b)
solution = [round(num, 2) for num in solution]
print(solution)  # Expected output: [1, 1, 1]

A = [[2, 1, -1], [-3, -1, 2], [-2, 1, 2]]
b = [8, -11, -3]
solution = solve(A, b)
solution = [round(num, 2) for num in solution]
print(solution)  # Expected output: [2, 3, -1]


# Example usage of the det function
A = [[1, 2], [3, 4]]
determinant = det(A)
print(determinant)  # Expected output: -2

A = [[1, 2, 3], [4, 5, 6], [7, 8, 9]]
determinant = det(A)
print(determinant)  # Expected output: 0

augmented_matrix = [
    [2, 1, -1, 8],
    [-3, -1, 2, -11],
    [-2, 1, 2, -3]
]

solution = gauss_jordan_elimination(augmented_matrix)

print("Solution:")
for i, val in enumerate(solution):
    print(f"x{i + 1} = {val}")
