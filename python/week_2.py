def function(t):
    words = t.split()
    word_count = len(words)
    return word_count
x = input("Enter the text you want to count: ")
result = function(x)
print(f"Number of words: {result}")