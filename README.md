README: Expression Evaluator for Spreadsheet Cells
This Java code evaluates mathematical expressions with references to spreadsheet-style cells (e.g., A1, B2). It supports basic arithmetic (+, -, *, /), nested parentheses, and dynamic cell value retrieval.

Key Functions:
eval(int x, int y)
Evaluates the expression stored in cell (x, y).

eval(String str)
Recursively evaluates a mathematical expression, handling operators and parentheses.

replaceCellValues(String str)
Replaces cell references with their actual values.

getCellValue(int x, int y)
Retrieves the value of a cell. Can be customized for your data source.

 SCell Class Implementation
The SCell class represents a single cell in a spreadsheet. It handles various data types, supports mathematical formulas, and validates expressions.

Key Features:
Cell Data Management:

Stores raw input (line) and processed result (data).
Supports types: NUMBER, TEXT, FORMULA, and ERROR.
Dynamic Evaluation:

Processes formulas starting with = by replacing cell references with values and evaluating the expression.
Supports parentheses and basic operators (+, -, *, /).
Validation:

Ensures formula correctness (bracket balance, valid operators, and numeric checks).
Integration:

replaceCellValues: Maps cell references (e.g., A1) to their corresponding values.
Compatible with external utilities (Ex2Utils and Ex2Sheet).
