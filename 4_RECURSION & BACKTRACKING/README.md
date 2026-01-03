# Backtracking — One Page Revision

This note is a quick reference for backtracking problems.  
Use it when revising or when stuck while coding.

---

## What backtracking really is

Backtracking is trying all possible choices step by step.  
If a choice doesn’t work, we undo it and try the next one.

In short:
> Make a choice → go deeper → undo the choice → try next choice

---

## 1. Define the state (what changes)

Before writing code, ask:
- What changes as recursion goes deeper?

Common examples:
- current index
- current list / path / string
- remaining target or sum
- current cell position (row, col)
- visited array

These become the parameters of the recursive function.

---

## 2. Base case (when to stop)

Ask:
- When is the current path complete?
- When is it invalid?

Typical base cases:
- index reaches end
- target becomes 0
- target < 0
- string becomes empty
- reached destination cell

At base case:
- store the answer OR
- return immediately

---

## 3. Choices (what can I do here?)

At every level, you usually have:
- include / exclude
- move in directions (U, D, L, R)
- pick one element from many (loop)
- take a prefix or skip it

These choices are implemented using:
- loops
- yes / no recursion

---

## 4. The golden rule: Do → Explore → Undo

This is the heart of backtracking.

### Do
Make a choice  
Examples:
- add element to list
- mark a cell as visited
- append a character

### Explore
Call recursion with updated state

### Undo
Reverse exactly what you did  
Examples:
- remove last element
- unmark visited
- remove appended character

If you forget **Undo**, the solution will be wrong.

---

## 5. Pruning (stop early)

Pruning means stopping paths that cannot lead to a valid answer.

Common pruning checks:
- target < 0
- out of bounds
- already visited
- duplicate choice at the same level

Pruning saves time and avoids TLE.

---

## How to recognize backtracking problems

If the problem says:
- "all possible"
- "generate"
- "find all ways"
- "unique combinations"
- "paths"

Think **backtracking**.

---

## Common mistakes to avoid

- Adding the same list reference to the result
- Forgetting to undo a change
- Missing visited array in maze/graph problems
- Handling duplicates incorrectly
- Wrong base case order

---

## Mental checklist while coding

Before moving on, ask:
- Do I have a clear base case?
- Did I undo everything I changed?
- Am I stopping invalid paths early?
- Am I exploring all valid choices?

If yes → you’re on the right track.

---

## One-line takeaway

Backtracking is **DFS with undo**.
