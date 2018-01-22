@file:Suppress("UNUSED_PARAMETER")

package lesson4.task1

import lesson1.task1.discriminant
import lesson3.task1.isPrime
import lesson3.task1.maxDivisor
import lesson3.task1.minDivisor

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val resultult = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            resultult.add(element)
        }
    }
    return resultult
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var abs = 0.0
    for (elem in v) abs += (elem * elem)
    return Math.sqrt(abs)
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = if (list.isEmpty()) 0.0 else list.sum() / list.size

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    if (list.isEmpty()) return list
    val avg = list.sum() / list.size
    for (elCount in 0 until list.size) {
        list[elCount] -= avg
    }
    return list
}


/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    var multi = 0.0
    for (i in 0 until a.size) multi += a[i] * b[i]
    return multi
}


/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    var resultult = 0.0
    var power = 1.0
    for (i in 0 until p.size) {
        resultult += p[i] * power
        power *= x
    }
    return resultult
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    if (list.isEmpty()) return list
    for (i in 1..list.lastIndex) {
        list[i] += list[i-1]
    }
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    val result = mutableListOf<Int>()
    if (isPrime(n)) {
        result.add(n)
        return result
    }
    var number = n
    while (number >= 2) {
        for (i in 2..n / 2) {
            if (number % i == 0) {
                result.add(i)
                number /= i
                break
            }
        }
    }
    return result
}


/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String =
        factorize(n).joinToString(separator = "*")


/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    if (n == 0) return listOf(0)
    var nCopy = n
    val newN = mutableListOf<Int>()
    while (nCopy > 0) {
        newN.add(nCopy % base)
        nCopy /= base
    }
    return newN.reversed()
}


/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    val list = convert(n, base)
    val abc = "abcdefghijklmnopqrstuvwxyz"
    var str = ""
    for (i in 0 until list.size)
        str += if (list[i] < 10) list[i] else
            abc[list[i] - 10]
    return str
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var n = 0
    val list = digits.reversed()
    var toMult = 1
    for (elCount in 0 until digits.size) {
        n += list[elCount] * toMult
        toMult *= base
    }
    return n
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    val list = mutableListOf<Int>()
    val ch = "0123456789"
    val abc = "abcdefghijklmnopqrstuvwxyz"
    for (i in 0 until str.length)
        if (str[i] in ch) list.add(ch.indexOf(str[i], 0)) else
            list.add(abc.indexOf(str[i], 0) + 10)
    return decimal(list, base)
}


/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    var numberber = ""
    val arabnumberb = listOf<Int>(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
    val rimnumberb = listOf<String>("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
    var natur = n
    var i = 0
    while (arabnumberb[i] > n) i += 1
    while (natur > 0) {
        while (natur - arabnumberb[i] >= 0) {
            numberber += rimnumberb[i]
            natur -= arabnumberb[i]
        }
        i += 1
    }
    return numberber
}


/** вспомогательная */
fun inRussian(fromOut: Int, time: Int): MutableList<String> {
    val result = mutableListOf<String>()
    val digits = fromOut % 10
    val dozen = (fromOut % 100) / 10
    val hundred = fromOut / 100
    val list1_9 = listOf("", "один", "два", "три", "четыре", "пять", "шесть", "семь",
            "восемь", "девять")
    val list10_19 = listOf("десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать",
            "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать")
    val list20_90 = listOf("", "", "двадцать", "тридцать", "сорок", "пятьдесят",
            "шестьдесят", "семьдесят", "восемьдесят", "девяносто")
    val list100_900 = listOf("", "сто", "двести", "триста", "четыреста",
            "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот")
    val listSecPart = listOf("тысяч", "одна тысяча", "две тысячи", "три тысячи", "четыре тысячи",
            "пять тысяч", "шесть тысяч", "семь тысяч", "восемь тысяч", "девять тысяч")
    result.add(list100_900[hundred])
    if (dozen == 1) {
        result.add(list10_19[digits])
        if (time == 2) result.add(listSecPart[0])
    } else {
        result.add(list20_90[dozen])
        if (time == 1) result.add(list1_9[digits])
        else if (fromOut != 0) result.add(listSecPart[digits])
    }
    return result

}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    val thousand = n / 1000
    val digit = n % 1000
    val answer = (inRussian(thousand, 2) + inRussian(digit, 1)).filter { it != "" }
    return answer.joinToString(separator = " ")
}