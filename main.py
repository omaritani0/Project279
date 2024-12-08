from flask import Flask, request, jsonify
import sqlite3
import os

app = Flask(__name__)

# Initialize SQLite database
def init_db():
    # Full path to the database file
    db_path = r'C:\Users\Itani\Desktop\api\messages.db'
    
    # Ensure the directory exists
    os.makedirs(os.path.dirname(db_path), exist_ok=True)
    
    # Connect to the SQLite database
    conn = sqlite3.connect(db_path)
    cursor = conn.cursor()
    cursor.execute('''CREATE TABLE IF NOT EXISTS messages (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        message TEXT NOT NULL,
                        chat_name TEXT NOT NULL)''')  # Added chat_name
    conn.commit()
    conn.close()

# GET endpoint to retrieve all messages for a specific chat
@app.route('/api/messages', methods=['GET'])
def get_messages():
    chat_name = request.args.get('chatName')
    if not chat_name:
        return jsonify({'error': 'chatName is required'}), 400

    db_path = r'C:\Users\Itani\Desktop\api\messages.db'  # Full path to the database file
    conn = sqlite3.connect(db_path)
    cursor = conn.cursor()
    cursor.execute('SELECT * FROM messages WHERE chat_name = ?', (chat_name,))
    rows = cursor.fetchall()
    conn.close()
    
    return jsonify([{'id': row[0], 'message': row[1], 'chat_name': row[2]} for row in rows]), 200

# POST endpoint to send a new message

@app.route('/api/messages', methods=['POST'])
def add_message():
    data = request.get_json()
    print("Received data:", data)  # Print the received data for debugging
    
    if not data or 'message' not in data or 'chatName' not in data:  # Accept 'chatName'
        return jsonify({'error': 'Message and chatName are required'}), 400
    
    try:
        db_path = r'C:\Users\Itani\Desktop\api\messages.db'  # Full path to the database file
        conn = sqlite3.connect(db_path)
        cursor = conn.cursor()
        cursor.execute('INSERT INTO messages (message, chat_name) VALUES (?, ?)', 
                       (data['message'], data['chatName']))  # Use 'chatName'
        conn.commit()
        conn.close()
        return jsonify(), 201  # Return empty response with status 201
    except Exception as e:
        return jsonify({'error': str(e)}), 500



if __name__ == '__main__':
    init_db()
    app.run(host='0.0.0.0', port=5000)
