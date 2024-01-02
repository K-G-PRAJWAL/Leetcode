/**
 * @param {number[]} positions
 * @param {number[]} healths
 * @param {string} directions
 * @return {number[]}
 */
var survivedRobotsHealths = function(positions, healths, directions) {
    const posWithIndex = new Array(positions.length)

    for(let i = 0; i< positions.length; i++) {
        posWithIndex[i] = [i, positions[i]]
    }

    posWithIndex.sort((a, b) => a[1] - b[1])  // sort based on positions

    const stack = []
    let prev, curr;

    for(let i = 0; i<positions.length; i++) {
        if(directions[posWithIndex[i][0]] === 'R') {
            stack.push(posWithIndex[i])
        } else {
            curr = posWithIndex[i]
            while(stack.length && curr && directions[stack[(prev = stack.length-1)][0]]==='R') {
                if(healths[stack[prev][0]]==healths[curr[0]]) {
                    curr = null
                    stack.pop()
                } else if (healths[stack[prev][0]] < healths[curr[0]]) {
                    if(--healths[curr[0]] === 0) curr  = null 
                    stack.pop()
                } else {
                    if(--healths[stack[prev][0]]===0) stack.pop()
                    curr = null
                }
            }
            if (curr) stack.push(curr)
        }
    }

    stack.sort((a,b)=>a[0]-b[0])
    return stack.map(m => healths[m[0]])
};