import random

class Quiz:
    def __init__(self, questions):
        self.questions = questions
        self.score = 0

    def display_question(self, question):
        print(question['text'])
        for i, option in enumerate(question['options'], start=1):
            print(f"{i}. {option}")
        user_input = input("Your answer (1-{}): ".format(len(question['options'])))
        return int(user_input) - 1  # Adjusting user input to match list indices

    def run_quiz(self):
        for question in self.questions:
            user_answer_index = self.display_question(question)
            if question['options'][user_answer_index] == question['correct_answer']:
                print("Correct!\n")
                self.score += 1
            else:
                print(f"Incorrect. The correct answer is: {question['correct_answer']}\n")

    def display_final_score(self):
        print("Quiz completed. Your final score: {}/{}".format(self.score, len(self.questions)))

# Define your questions and options
questions = [
    {
        'text': 'What is the largest ocean on Earth?',
        'options': ['Atlantic Ocean', 'Indian Ocean', 'Southern Ocean', 'Pacific Ocean'],
        'correct_answer': 'Pacific Ocean'
    },
    {
        'text': 'Who wrote the play "Romeo and Juliet"?',
        'options': ['William Shakespeare', 'Jane Austen', 'Charles Dickens', 'Leo Tolstoy'],
        'correct_answer': 'William Shakespeare'
    },
    {
        'text': 'What is the capital of Japan?',
        'options': ['Beijing', 'Seoul', 'Tokyo', 'Bangkok'],
        'correct_answer': 'Tokyo'
    }
]

# Shuffle the questions to make the quiz more dynamic
random.shuffle(questions)

# Create a Quiz instance and run the quiz
quiz = Quiz(questions)
quiz.run_quiz()

# Display the final score
quiz.display_final_score()