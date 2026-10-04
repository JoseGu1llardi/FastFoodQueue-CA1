# Data Structure Decision-Making Process

## Problem Analysis
The fast-food restaurant scenario requires:
- Adding food items from one side (rear)
- Removing food items from the opposite side (front)
- Maximum capacity of 8 trays
- Track name, weight, best-before date, and added time

## Options Considered

### Option 1: Stack (LIFO - Last In, First Out)
- **How it works:** Items are added and removed from the same side (top).
- **Why rejected:** The scenario clearly states the chef adds food from the
  front and the staff removes from the opposite side. A Stack would remove
  the LAST item added, which means the oldest food would stay in storage
  longer and could expire. This does NOT match the real-world fast-food flow.
- **Verdict:** Not suitable

### Option 2: Queue (FIFO - First In, First Out)
- **How it works:** Items are added at the rear and removed from the front.
- **Why accepted:** This perfectly matches the scenario. The first food item
  placed in storage is the first one removed and served to the customer.
  This ensures food freshness and follows real-world fast-food operations.
- **Verdict:** Best choice

### Option 3: Deque (Double-Ended Queue)
- **How it works:** Items can be added or removed from BOTH sides.
- **Why rejected:** While flexible, it is more complex than needed. The
  scenario only requires adding from one side and removing from the other.
  Using a Deque would add unnecessary complexity without any benefit.
- **Verdict:** Over-engineered for this problem

### Option 4: ArrayList (Dynamic Array)
- **How it works:** Items can be added or removed from any position.
- **Why rejected:** No built-in order enforcement. We would need to manually
  manage which item to remove first. This defeats the purpose of using a
  proper data structure and increases the chance of errors.
- **Verdict:** No natural ordering

## Final Decision: Queue (FIFO)

### Justification
1. **Matches the scenario:** The assignment says "use the front side for
   adding food items and the opposite side for removing them." This is
   exactly how a Queue works (enqueue at rear, dequeue at front).
2. **Food freshness:** FIFO ensures the oldest food is served first,
   preventing expired items from staying in storage.
3. **Simplicity:** Queue is simple to implement and understand, with O(1)
   time complexity for both add and remove operations.
4. **Real-world accuracy:** Fast-food restaurants naturally follow FIFO
   to maintain food quality and customer satisfaction.

### Advantages of Queue
- O(1) time complexity for enqueue and dequeue operations
- Natural FIFO ordering matches real-world fast-food flow
- Simple to implement and maintain
- Ensures food freshness by serving oldest items first
- Easy to validate capacity (fixed size of 8)

### Limitations of Queue
- Fixed order: Cannot prioritize urgent orders
- Fixed capacity: Limited to 8 trays, overflow must be handled
- No random access: Cannot access items in the middle without removing
  items from the front
- No search efficiency: Searching for a specific item is O(n)

## Time Complexity Summary

| Operation    | Complexity | Reason                              |
|-------------|-----------|--------------------------------------|
| enqueue()   | O(1)      | Add to end of queue is constant      |
| dequeue()   | O(1)      | Remove from front is constant        |
| peek()      | O(1)      | View first item is constant          |
| isEmpty()   | O(1)      | Check size is constant               |
| isFull()    | O(1)      | Check size is constant               |
| displayAll()| O(n)      | Must loop through all n items        |
| search()    | O(n)      | Must check each item in worst case   |