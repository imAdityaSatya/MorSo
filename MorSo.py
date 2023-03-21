morse_key = { 'A':'.-', 'B':'-...',
				'C':'-.-.', 'D':'-..', 'E':'.',
				'F':'..-.', 'G':'--.', 'H':'....',
				'I':'..', 'J':'.---', 'K':'-.-',
				'L':'.-..', 'M':'--', 'N':'-.',
				'O':'---', 'P':'.--.', 'Q':'--.-',
				'R':'.-.', 'S':'...', 'T':'-',
				'U':'..-', 'V':'...-', 'W':'.--',
				'X':'-..-', 'Y':'-.--', 'Z':'--..',
				'1':'.----', '2':'..---', '3':'...--',
				'4':'....-', '5':'.....', '6':'-....',
				'7':'--...', '8':'---..', '9':'----.',
				'0':'-----'}

def encode(msg):
	cipher= ''
	for ch in msg:
		if ch!=' ':
			cipher+= morse_key[ch] + ' '
		else:
			cipher+=' '
	return cipher

def decode(msg):
	msg += ' '
	decipher = ''
	citext = ''
	for ch in msg:
		if ch!=' ':
			i=0
			citext+= ch
		else:
			i+=1
			if i==2:
				decipher+=' '
			else:
				decipher+= list(morse_key.keys())[list(morse_key.values()).index(citext)]
				citext = ''
	return decipher

def main():
	text = input("Enter the text here=> ")
	result = encode(text.upper())
	print(text," => ",result)

if __name__ == '__main__':
	main()
