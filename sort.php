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


