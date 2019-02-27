<?php

$a = array(1,10,0,-9,20,77,23,54);

function qicksort(array& $arr, int $left, int $right)
{
        if($left>= $right){
                return;
        }

        $l = $left;
        $r = $right;

        $key = $arr[$left];

        while($l<$r) {

                while($r>$l && $arr[$r]>$key){
                        $r--;
                }
                $arr[$l] = $arr[$r];
                while($l<$r && $arr[$l]<$key)
                {
                        $l++;
                }
                $arr[$r] = $arr[$l];
        }
        $arr[$l] = $key;

        qicksort($arr,$left,$l-1);
        qicksort($arr,$l+1,$right);

}

qicksort($a,0,count($a)-1);
var_dump($a);



function checkstr(string $str)
{
    $l = strlen($str);
    $i=0;
    $j=$l-1;
    while($i<$j){
        if($str[$i++] != $str[$j--]) {
            return false;
        }
    }
    return true;
   
}

var_dump(checkstr("abeba"));
var_dump(checkstr("abca"));
var_dump(checkstr("aba"));
var_dump(checkstr("a"));
var_dump(checkstr(""));



function heapfiy(array& $arr,int $par,int $end) {

	$dad = $par;
	$son = $dad*2+1;
	while($son<=$end) {

		if($son+1<=$end && $arr[$son+1]>$arr[$son]) {
			$son++;
		}

		if($arr[$son] <= $arr[$dad]) {
			return;
		}

		$tmp = $arr[$dad];
		$arr[$dad] = $arr[$son];
		$arr[$son] = $tmp;

		$dad = $son;
		$son = $dad*2+1;
		if($son > $end) {
			return;
		}

	}
}
/*
1 2 3 4 5 6 7 8

        1
    2     3
 4   5  6  7
8

*/
function heapsort(array& $arr, int $length) {

	if ($length <= 1) { return; }
	$lastparent = $length / 2 - 1;
	for ( ; $lastparent >=0; $lastparent--) {
		heapfiy($arr,$lastparent, $length -1);
	}
	for ($i = $length -1; $i > 0; $i--) {

		$tmp = $arr[$i];
		$arr[$i] = $arr[0];
		$arr[0] = $tmp;

		heapfiy($arr,0, $i - 1);
	}

}

$arr = [8,9,6,1,3,10,88,4];
heapsort($arr,count($arr));
var_dump($arr);



$arr = [1,0,-10,78,8,9,6,1,3,10,88,4];
heapsort($arr,count($arr));
var_dump($arr);
