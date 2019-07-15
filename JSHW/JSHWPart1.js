/*
 1. Return the nth Fibonacci number
`x`
 f(0) = 0
 f(1) = 1
 f(10) = 55 
*/

function fibonacci(n) {
    let array = [0, 1];
    if (n <= 2) return 1;
    for (let x = 2; x <= n; x++) {
      array[x] = array[x - 1] + array[x - 2];
    }
    return array[n];
}

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame... super.lame
*/

function sort(array){
    for (let x = 0; x < array.length; x++){
        if (array[x] > array[x + 1]){
            let y = array[x];
            array[x] = array[x + 1];
            array[x + 1] = y; 
        }
    }
    return array;
}

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/

function factorial(n){
    let x = 1;
    for (let y = n; y > 0; y--){
        x = x * y; 
    }
    return x;
}

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]
*/

function rotate(array, n){
    for (let x = 0; x < n; x++){
        let y = array[0];
        for (let z = 0; z < array.length; z++){
            array[z] = array[z + 1]; 
        }
        array[array.length - 1] = y; 
    }
    return array; 
}

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/
