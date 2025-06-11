import Data.List (sort)

a:: Float -> Float
a x = 3.14 * x**2

b:: Float-> Float-> Float -> Float
b x y z = (x*y/100)*z

c:: Float -> Float -> Float
c x y = max x y

d:: Float -> Int
d x 
    | x > 0 = 1
    | x < 0 = -1
    | otherwise = 0

delta :: Float -> Float -> Float -> Float  
delta a b c = b**2 - 4 * a * c

e:: Float ->Float ->Float -> (Float,Float)
e a b c =
    let aa = delta a b c
        x1=(-b + sqrt aa) / (2*a)
        x2=(-b - sqrt aa) / (2*a)
    in (x1, x2)

f:: Float -> Float
f 1 = 1    
f x = f (x-1) * x    

g:: Int-> Int -> Int
g a 0 = abs a
g a b = g b (a `mod` b)

h:: Int-> Int
h 0 = 0
h 1 = 1
h x = h(x-1) + h(x-2)

i:: [Int] -> Int
i = sum

j:: [Int] -> Int
j = minimum

k:: Int -> [Int]
k n = map h [0..(n-1)]

l:: Int -> [Int] -> Bool
l = elem

m :: [Int] -> [Int]
m = sort 

n:: [a] -> [a] -> [a]
n [] ys = ys
n xs [] = xs
n (x:xs) (y:ys) = x: y : n xs ys