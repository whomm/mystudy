#!/usr/bin/python
import pprint
import glob
import os
import sys
from PIL import Image
import cv2


EXTS = 'jpg', 'jpeg', 'JPG', 'JPEG', 'gif', 'GIF', 'png', 'PNG'

def avhash(im):
    if not isinstance(im, Image.Image):
        im = Image.open(im)
    im = im.resize((8, 8), Image.ANTIALIAS).convert('L')
    avg = reduce(lambda x, y: x + y, im.getdata()) / 64.
    return hex(reduce(lambda x, (y, z): x | (z << (63-y)),
                  enumerate(map(lambda i: 0 if i < avg else 1, im.getdata())),
                  0)
    )

def hamming(h1, h2):
    h, d = 0, h1 ^ h2
    while d:
        h += 1
        d &= d - 1
    return h   

print(avhash('./dcd_a.jpeg'))


print(cv2.__version__)


a_1 = cv2.imread("dcd_a.jpeg")
a_2 = cv2.imread("qczj_a.jpg")


print('---- PHash')
hsh = cv2.img_hash.PHash_create()
print(hsh.compute(a_1))
print(hsh.compute(a_2))

print('---- AverageHash')
ahash = cv2.img_hash.AverageHash_create()
print(ahash.compute(a_1))
print(ahash.compute(a_2))

print('---- BlockMeanHash_create')
ahash = cv2.img_hash.BlockMeanHash_create()
print(ahash.compute(a_1))
print(ahash.compute(a_2))


print('---- ColorMomentHash')
ahash = cv2.img_hash.ColorMomentHash_create()
print(ahash.compute(a_1))
print(ahash.compute(a_2))


print('---- RadialVarianceHash')
ahash = cv2.img_hash.RadialVarianceHash_create()
print(ahash.compute(a_1))
print(ahash.compute(a_2))


print('---- MarrHildrethHash')
ahash = cv2.img_hash.MarrHildrethHash_create()
print(ahash.compute(a_1))
print(ahash.compute(a_2))
