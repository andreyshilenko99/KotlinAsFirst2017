@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var number = 0
    var x = n
    if (x == 0) return (1)
    while (x > 0) {
        number += 1
        x /= 10
    }
    return (number)
}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var gyt = 0
    var c = 1
    var a = 0
    var i = 0
    while (n > i) {
        a = c
        c = gyt
        gyt = a + gyt
        i++
    }
    return gyt
}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var minmultiple = 1
    var minmultiple2 = 1
    for (i in 1..m * n) {
        if ((i % n == 0) && (i % m == 0)) return minmultiple * i
        minmultiple2 = minmultiple * i

    }
    return minmultiple2

}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var mindivisor = 1
    for (i in 2..n) {
        if (n % i == 0) return i
        mindivisor = mindivisor * i

    }
    return mindivisor
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var maxdivisor = 1
    for (divisor in n - 1 downTo 1)
        if (n % divisor == 0) {
            maxdivisor = divisor; break
        }
    return maxdivisor
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var count = 0
    if (n > m)
        for (i in 2..n) {
            if ((n % i == 0) && (m % i == 0))
                count++
        }
    else
        for (i in 2..m) {
            if ((n % i == 0) && (m % i == 0))
                count++
        }
    if (count > 0) return false
    else return true
}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var numb: Int = Math.sqrt(m.toDouble()).toInt()
    if (numb * numb < m) numb++
    return if (numb <= Math.sqrt(n.toDouble())) true else false
}


/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    var counter = 1
    var sin = x % (2 * Math.PI)
    val sinConst = sin
    var equation = sin
    while (Math.abs(equation) >= eps) {
        equation = -equation * sinConst / ((counter * 2 + 1) * (counter * 2)).toDouble() * sinConst
        counter += 1
        sin += equation
    }
    return sin
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    var equation = 1.0
    var counter = 1
    var cos = 1.0
    val const = x % (2 * Math.PI)
    while (Math.abs(equation) >= eps) {
        equation = -equation * const / ((counter * 2 - 1) * (counter * 2)).toDouble() * const
        counter += 1
        cos += equation
    }
    return cos
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var revert = 0
    var number = n
    while (number >= 1) {
        revert = number % 10 + revert * 10
        number /= 10
    }
    return revert
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean {
    var palindrome = 0
    var number = n
    while (n > palindrome) {
        palindrome = number % 10 + palindrome * 10
        number /= 10

    }
    if (n == palindrome) return true
    else return false
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean = digitCountInNumber(n, n % 10) != "$n".length

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var numbers = 1
    var str = ""
    var nn = n
    while (nn > 0) {
        val sqrnumb = numbers * numbers
        str = "$sqrnumb"
        numbers++
        nn -= str.length
    }
    numbers = str.length - 1 + nn
    return str[numbers].toString().toInt()
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var numbers = 1
    var str = ""
    var nn = n
    while (nn > 0) {
        val fibnumb = fib(numbers)
        str = "$fibnumb"
        numbers++
        nn -= str.length
    }
    numbers = str.length - 1 + nn
    return str[numbers].toString().toInt()
}
