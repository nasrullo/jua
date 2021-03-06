x = {1, 2, 3}
print(x == {1, 2, 3})

function inspect(count)
    print("inspect number: " .. count)
    print(x[0])
    print(x[1])
    print(x[2])
    print(x[3])
    print(x[4])
    print(x[5])
    print(x[100])
    print(x['test'])
    print(x['test2'])
    print(#x)
    print("---")
end
inspect(1)

x[1] = 'hello'
inspect(2)

x['test'] = 'test-string'
inspect(3)

x.test = 'cc'
inspect(4)

x.test2 = 'new'
inspect(5)

table.remove(x, 1)
inspect(6)

table.insert(x, "last")
inspect(7)

x[#x + 1] = "new last"
inspect(8)

print(table.concat(x, "|"))

x.func = function() print("hi") end
x.func()

x = {1, 2, 3}
inspect(9)

x[100] = 100
inspect(10)

x[5] = 5
inspect(11)

x[4] = 4
inspect(12)

print(#{hello = 1, hi = 2})
print(#{[4.5] = 1, [3.2] = 2})

x.print = function(table) print(table[1]) end
x.set = function(table, key, val)
    table[key] = 'got reset ! ' .. val
end

x.print(x)
x:print()

x:set('test', 'boom')
x:set(1, 'boom for 1 !')
inspect(13)

-- this also test that in the function not_method table refers
-- to the variable and not the builtin since it's a new scope
function x.not_method(table)
    if table then
        print(table[1])
    else
        print("nope")
    end
end

x.not_method()
x:not_method()

-- TODO: uncomment once methods assignments are supported
-- function x:append(key, str)
--    x[key] = x[key] .. str
-- end
--
-- x:append(1, "and append !")
-- inspect(14)
--
-- x.y = {}
--
-- function x.y:set(key, val)
--     x.y[key] = val
-- end
--
-- x.y:set(1, 2)
-- print(x.y[1] * 50)
