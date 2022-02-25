const DocusignStrategy = require('passport-docusign').Strategy;
const passport = require('passport');

passport.use(new DocusignStrategy({
  clientID: '1962323a-1815-4d7c-832c-0dc801a8dfb0',
  clientSecret: '10d028e9-06a5-4687-8cf9-cd42bf3ff113',
  callbackURL: 'http://www.example.com'
},function(acessToken, refreshToken, profile, cb) {
  User.findOrCreate({ email: profile.email }, function(err, user) {
    return cb(err, user);
  })
}))

class DocusignController {
  async call(req, res) {
    res.status(200);
    return passport.authenticate('docusign')
  }  
}

export default new DocusignController();





