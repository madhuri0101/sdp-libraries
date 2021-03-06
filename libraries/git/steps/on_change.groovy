/*
  Copyright © 2018 Booz Allen Hamilton. All Rights Reserved.
  This software package is licensed under the Booz Allen Public License. The license can be found in the License file or at http://boozallen.github.io/licenses/bapl
*/
package libraries.git

void call(Map args = [:], body){

  // do nothing if not commit or pr
  if (!(env.GIT_BUILD_CAUSE in ["commit", "pr"]))
    return

  def branch = env.BRANCH_NAME

  // do nothing if branch doesn't match regex
  if (args.to)
  if (!(branch ==~ args.to))
    return

  println "running because of a commit to ${branch}"
  body()

}
