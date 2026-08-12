# Lab 05 — Loop Fundamentals

| | |
|---|---|
| **Week** | 5 |
| **Textbook** | Liang — **Chapter 5** (Loops) |
| **Time budget** | 60 minutes |
| **Points** | 100 |

---

## Learning Objectives

1. Write a counter-controlled `for` loop with an accumulator.
2. Write a sentinel-controlled `while` loop that does not process the sentinel.
3. Distinguish `print` from `println` when building a single line of output inside a loop.
4. Guard a division so that an empty data set cannot cause a divide-by-zero defect.

---

## Background

**Accumulator pattern.** Initialise outside the loop, update inside it:

```java
int sum = 0;                      // nothing has been added yet
for (int i = 1; i <= n; i++) {    // i takes the values 1, 2, ..., n
    sum += i;                     // shorthand for sum = sum + i
}
```

Declaring `sum` *inside* the loop resets it on every pass — a classic defect that always reports
the last value instead of the total.

**Sentinel-controlled loop.** The sentinel marks the end of the data and is not itself data. The
standard shape reads one value *before* the test, so the sentinel is never processed:

```java
int value = input.nextInt();   // priming read
while (value != -1) {          // -1 ends the data
    total += value;            // process the real value
    count++;
    value = input.nextInt();   // read the next candidate
}
```

Omitting the final read produces an infinite loop, because the condition can never change.

**Guarding the division.** `total / count` when `count` is 0 divides by zero. With `double`
operands this yields `NaN` rather than an exception, which is worse: the program keeps running and
prints nonsense. Test `count > 0` before dividing.

---

## Instructions

### Part A — Summation (Steps 1–2)

Read `n`, then use a `for` loop to add every integer from 1 through `n`. Print:

```
Sum 1 to 10: 55
```

Both the `10` and the `55` must come from variables.

### Part B — Multiplication Table Row (Step 3)

Read a multiplier `m`, then print its first nine multiples on one line:

```
Table row: 7 14 21 28 35 42 49 56 63
```

Print the label with `print`, print each value with `print`, separate values with **single**
spaces, and call `println()` once after the loop to end the line. Watch the trailing space: the
grader compares the sequence `7 14 21 28 35 42 49 56 63` as a unit, so an extra space between two
numbers will fail.

### Part C — Sentinel Average (Steps 4–6)

Read integers until the user enters `-1`. The sentinel is neither counted nor added. Then print:

```
Count: 3
Average: 9.00
```

When no values were entered before the sentinel, print:

```
Count: 0
Average: N/A
```

---

## Commenting Standard (20 points)

```java
// WEAK
int sum = 0;  // set sum

// STRONG
// The accumulator is declared BEFORE the loop so that it survives every
// iteration; declaring it inside would reset it to 0 on each pass.
int sum = 0;
```

---

## Compile, Run, and Test

```bash
bash tools/run_lab.sh lab05          # 13 official checks
python3 tools/comment_check.py labs/lab05
```

---

## Sample Run

```
Enter n: 10
Sum 1 to 10: 55
Enter a multiplier: 7
Table row: 7 14 21 28 35 42 49 56 63
Enter numbers, then -1 to stop:
4 8 15 -1
Count: 3
Average: 9.00
```

**Cases the driver checks:** `n=10, m=7, {4,8,15}` · `n=5, m=3, {10,20}` ·
`n=1, m=9, {}` (empty data set) · `n=100` (the sum is 5050).

---

## Grading Rubric

| Criterion | Points |
|---|---|
| All 13 checks pass | 60 |
| Line comments explain every statement, including loop conditions | 20 |
| Correct loop choice, accumulator placement, guarded division | 10 |
| Committed and pushed on time | 10 |

---

## Submission Checklist

- [ ] `bash tools/run_lab.sh lab05` reports 13 of 13.
- [ ] Entering `-1` immediately prints `Count: 0` and `Average: N/A`, not `NaN`.
- [ ] The table row is on a single line.

```bash
git add . && git commit -m "Lab 05 complete - all 13 checks passing" && git push
```

---

## Stretch Goal

Extend Part C to also report the smallest and largest values entered. Initialise your minimum and
maximum from the **first** value read, not from 0 — otherwise a data set of all-positive numbers
reports a minimum of 0.

---

## Troubleshooting

| Symptom | Cause | Fix |
|---|---|---|
| Program never stops | The loop body never reads a new value | Add the read at the end of the body |
| `Sum 1 to 10: 10` | `sum` declared inside the loop | Move the declaration above the loop |
| Table row printed vertically | Used `println` inside the loop | Use `print`, then one `println()` after |
| `Average: NaN` | Divided by a zero count | Guard with `if (count > 0)` |
| Count is one too high | The sentinel was counted | Read before the test; do not process `-1` |

