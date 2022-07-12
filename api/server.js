const fs = require('fs')
const bodyParser = require('body-parser')
const jsonServer = require('json-server')
const jwt = require('jsonwebtoken')
const server = jsonServer.create()
const router = jsonServer.router('./database.json')
const userdb = JSON.parse(fs.readFileSync('./database.json', 'UTF-8'))
server.use(bodyParser.urlencoded({ extended: true }))
server.use(bodyParser.json())
server.use(jsonServer.defaults())
const SECRET_KEY = '123456789'
const expiresIn = '1h'

// Create a token from a payload
function createToken(payload) {
  return jwt.sign(payload, SECRET_KEY, { expiresIn })
}
// Verify the token
function verifyToken(token) {
  return jwt.verify(token, SECRET_KEY, (err, decode) =>
    decode !== undefined ? decode : err
  )
}
// Check if the user exists in database
function isAuthenticated({ username, password }) {
  return (
    userdb.users.findIndex(
      (user) => user.username === username && user.password === password
    ) !== -1
  )
}
// Check if the username exists in database
function checkUsernameHasRegisted(username) {
  return userdb.users.findIndex((user) => user.username === username) !== -1
}
// Register New User
server.post('/register', (req, res) => {
  console.log('register endpoint called; request body:')
  console.log(req.body)
  const { username, password } = req.body
  if (checkUsernameHasRegisted(username) === true) {
    const status = 401
    const message = 'Username alredy exists, please choose another username.'
    res.status(status).json({ status, message })
    return
  }
  fs.readFile('./database.json', (err, data) => {
    if (err) {
      const status = 401
      const message = err
      res.status(status).json({ status, message })
      return
    }
    // Get current users data
    var data = JSON.parse(data.toString())
    // Get the id of last user
    var last_item_id = data.users.length || 0
    //Add new user
    data.users.push({ id: last_item_id + 1, username, password })
    fs.writeFile('./database.json', JSON.stringify(data), (err) => {
      if (err) {
        const status = 401
        const message = err
        res.status(status).json({ status, message })
        return
      }
    })
  })
  // Create token for new user
  const message = 'Your account have been successfully registered.'
  const access_token = createToken({ username, password })
  console.log('Access Token:' + access_token)
  res.status(201).json({ access_token, message })
})
// Login to one of the users from ./database.json
server.post('/login', (req, res) => {
  console.log('login endpoint called; request body:')
  console.log(req.body)
  const { username, password } = req.body
  if (isAuthenticated({ username, password }) === false) {
    const status = 401
    const message = 'Username or Password is incorrect'
    res.status(status).json({ status, message })
    return
  }
  const message = 'Login successfully'
  const access_token = createToken({ username, password })
  console.log('Access Token:' + access_token)
  console.log(message)
  res.status(200).json({ access_token, message })
})
server.use(/^(?!\/).*$/, (req, res, next) => {
  if (
    req.headers.authorization === undefined ||
    req.headers.authorization.split(' ')[0] !== 'Bearer'
  ) {
    const status = 401
    const message = 'Error in authorization format'
    res.status(status).json({ status, message })
    return
  }
  try {
    let verifyTokenResult
    verifyTokenResult = verifyToken(req.headers.authorization.split(' ')[1])

    if (verifyTokenResult instanceof Error) {
      const status = 401
      const message = 'Access token not provided'
      res.status(status).json({ status, message })
      return
    }
    next()
  } catch (err) {
    const status = 401
    const message = 'Error access_token is revoked'
    res.status(status).json({ status, message })
  }
})
server.use(router)
server.listen(3000, () => {
  console.log('Run Auth API Server')
})
