# 380
# Implement integer division without using the division operator.
# Your function should return a tuple of (dividend, remainder)
# and it should take two numbers, the product and divisor.
#
# For example, calling divide(10, 3) should return (3, 1)
# since the divisor is 3 and the remainder is 1.
# Bonus: Can you do it in O(log n) time?

def devide(a, b):
    product = 0
    while a >=b:
        a -= b
        product += 1
    return product, a

def main():
    a = 20
    b = 5
    print(devide(a, b))

if __name__ == '__main__':
    main()
