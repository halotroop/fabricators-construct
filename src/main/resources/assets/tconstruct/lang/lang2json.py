from tkinter import filedialog, Tk
from json import dump

#opens the file dialogue window
root = Tk()
root.withdraw()
#only accepts lang files
file_path = filedialog.askopenfilename(filetypes = [("lang file", "*.lang")])

#splits the properties, and puts them straight into a dictionary
values = dict([x.split("=", 1)
              for x in open(file_path).read().splitlines() if x!= ""])

#saves the json file in the same location, with same name, as chosen lang file
dump(values, open(file_path[:-4] + "json", "w"), indent=4)
