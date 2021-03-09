// Copyright 2020 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomFact() {
  const facts =
      ['Born December 18, 2000', 'Youngest of three!', 'Likes to watch anime!', 'Black belt in Karate!'];

  // Pick a random fact.
  const fact = facts[Math.floor(Math.random() * facts.length)];

  // Add it to the page.
  const factContainer = document.getElementById('fact-container');
  factContainer.innerText = fact;
}

async function getArtist() {
    const responseFromServer = await fetch('/artist');
    const textResponse = await responseFromServer.json();

    console.log(textResponse.selectedArtist);

    const artistContainer = document.getElementById('artist-container');
    artistContainer.innerText = textResponse.selectedArtist;
}


// TODO: Eventually would like to use some type of boolean to show
//  that user submitted a comment and in return say thank you
// function thankUser() {
//     const responseFromServer = await fetch('/form-handler');

//     const thanksContainer = document.getElementById('thanks-text');
//     thanksContainer.innerText = responseFromServer;
// }