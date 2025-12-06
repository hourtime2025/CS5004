# SplitSmart — Domain Objects (Draft)

> Scope: Small, CS5005‑friendly. In‑memory data, CLI view, thorough unit tests.

## Core Entities
- **User**: `id`, `name`
- **Group**: `id`, `name`, `members: Set<User>`, `expenses: List<Expense>`
- **Money** *(value object)*: `amount: BigDecimal`, `currency: String`
- **Expense**: `id`, `payer: User`, `amount: Money`, `description`, `date`, `participants: Set<User>`, `splitStrategy: SplitStrategy`
- **SplitStrategy (interface)**:
  - `EqualSplitStrategy`
  - *(Stretch)* `WeightedSplitStrategy`, `PercentageSplitStrategy`
- **Share** *(computed)*: `user`, `amountOwed`
- **BalanceSheet**: `Map<User, Money>`
- **Settlement**: `from: User`, `to: User`, `amount: Money`
- **SettlementOptimizer**: input `BalanceSheet` → output `List<Settlement>`
- **Report / ReportExporter (interface)**:
  - `PlainTextReportExporter`
  - *(Stretch)* `CsvReportExporter`

## Application Layer
- **Controllers (CLI)**: `GroupController`, `ExpenseController`
- **View (CLI)**: `ConsoleView`
- **Repositories (in-memory)**: `GroupRepository`, `ExpenseRepository`

## Rough Relationships (ASCII UML)
```
Expense --uses--> SplitStrategy <|.. EqualSplitStrategy
                                 <|.. WeightedSplitStrategy
                                 <|.. PercentageSplitStrategy

Group *--* User
Group 1..* Expense

SettlementOptimizer --produces--> Settlement

ReportExporter <|.. PlainTextReportExporter
               <|.. CsvReportExporter
```

## MVP Flow
1. Create group → add members → add expenses (equal split).
2. Compute balances (aggregate shares per user).
3. Optimize settlements (minimal transfer set).
4. Export plain‑text report.
